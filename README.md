# ATMMachine


REST:<br />
  &nbsp;&nbsp;&nbsp;authorize: <br />
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; http://localhost:8081/auth/login?username=temo&password=123456 <br />
  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; verifyCode: <br />
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; http://localhost:8081/verify?id=10&twoFaCode=8497
  
  &nbsp;&nbsp;&nbsp;BankOperations: <br />
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; http://localhost:8081/api/deposit/111/500 <br />
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; http://localhost:8081/api/withdraw/111/500 <br />
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; http://localhost:8081/api/balance/111 <br />
  
