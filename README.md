# ATMMachine


REST:
  authorize:
    http://localhost:8081/auth/login?username=temo&password=123456
  verifyCode:
    http://localhost:8081/verify?id=10&twoFaCode=8497
  
  BankOperations:
    http://localhost:8081/api/deposit/111/500
    http://localhost:8081/api/withdraw/111/500
    http://localhost:8081/api/balance/111
  
