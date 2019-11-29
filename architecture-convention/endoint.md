# Java Project Architecture Convention > Endpoint

## PascalCase
- This directory named endpoint contains list of endpoints
- Begin with an uppercase letter end with Endpoint word
- Preferably a noun e.g. CarEndpoint, BirdEndpoint, MountainBikeEndpoint
- Avoid acronyms and abbreviations
- Only [services](./service.md) should be inject in the endpoint
- The endpoint is a kind of service all business logic should written here
- The endpoint receives an input parameter from the controller DTO, not an Entity
- The endpoint passes the Entity to the service, not a DTO and return to controller only DTO


```java
public class CompanyEndpoint {  
    private final CompanyService companyService;
    
    @Autowired
    public CompanyEndpoint(CompanyService companyService) {
        this.companyService = companyService;
    }
    
    public CompanyDTO someAction(RequestDTO requestDTO){
        
        Company company = companyService.someAction(requestDTO.getCompanyId());
        ...
        return convertToDTO(company);
    }   
    
    private CompanyDTO convertToDTO(Company company){
        ...
        return companyDTO;
    }

    ...
}  
```
