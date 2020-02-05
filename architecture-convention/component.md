# Java Project Architecture Convention > Component

## PascalCase
- This directory named component contains list of business logics
- Begin with an uppercase letter end with Component word
- Preferably a noun e.g. CarComponent, BirdComponent, MountainBikeComponent
- Avoid acronyms and abbreviations
- Only [services](./service.md) should be inject in the component
- The component is a kind of service all specific-reusable logic should written here
- The component receives an input parameter from the endpoint DTO or Entity
- The component passes the Entity to the service, not a DTO and return to endpoint DTO or Entity


```java
public class CompanyComponent {  
    private final CompanyService companyService;
    
    @Autowired
    public CompanyComponent(CompanyService companyService) {
        this.companyService = companyService;
    }
    
    public CompanyDTO someBusinessLogicAction(RequestDTO requestDTO){
        
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
