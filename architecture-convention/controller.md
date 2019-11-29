# Java Project Architecture Convention > Controller

## PascalCase
- This directory named controller contains list of controllers
- Begin with an uppercase letter end with Controller word
- Preferably a noun e.g. CarController, BirdController, MountainBikeController
- Avoid acronyms and abbreviations
- Only [endpoints](./controller.md) should be inject in the controller, not services, repositories, and preferably be final and injected by construct
- On create new record use @PostMapping, if action is update @PutMapping, on delete @DeleteMapping, on get one or list of elements and simple request use @GetMapping
- Errors must be handled inside the controller
- Don't write business logic in controller

```java
public class CompanyController {  
    private final CompanyEndpoint companyEndpoint;
    
    @Autowired
    public CompanyController(CompanyEndpoint companyEndpoint) {
        this.companyEndpoint = companyEndpoint;
    }

    @GettMapping("/test")
    public ResponseEntity<ResponseDTO> test() {
        ResponseDTO responseDTO = null;
        try {
            responseDTO = companyEndpoint.test();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    ...
}  
```
