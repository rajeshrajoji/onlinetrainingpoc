import {Component, OnInit, ViewEncapsulation} from '@angular/core';
import {User} from '../../model/model.user';
import {AccountService} from '../../services/account.service';
import {Router, ActivatedRoute} from '@angular/router';

@Component( {
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css'],
  encapsulation: ViewEncapsulation.None
})
export class RegisterComponent implements OnInit {
  user: User = new User();
  errorMessage: string;

  constructor(public accountService: AccountService, public router: Router, private route: ActivatedRoute) {
  }

  ngOnInit() {
  }

  register() {
    //let courseId = this.route.snapshot.paramMap.get('id');
    let courseId = this.route.snapshot.queryParamMap.get('course');
    courseId = courseId == null ? "0": courseId;
    if(parseInt(courseId) != 0) {
      let course = {
          "id":courseId
      };
      this.user.courses[0]= course;
    }
    this.accountService.createAccount(this.user).subscribe(data => {
        this.router.navigate(['/login']);
      }, err => {
        console.log(err);
        this.errorMessage = 'username already exist';
      }
    );
  }
}
