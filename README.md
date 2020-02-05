# JavaProjectConventions

* [Java Code Convention](naming/README.md)
* [Project Architecture Convention](architecture-convention/README.md)

= Coding Standards  =
- Always use blocks in if/while/for/do statements 
- Prefer primitive types over boxed primitives 
- Avoid long parameter list for methods and/or constructors. No more than 4 params. 
- Don't use *+* more than once in *String* concatenation 
- Don't use identity operator (*==*) to check *Object* equality - use *equals()*  
- Don't use *String*s or *int*s as constants - use *enum* 
- Log instances should be *private static final* 

= Best Practices  =

- Keep it simple! 
- Keep class/method visibility as low as possible (impls should be package visible) 
- Hide the implementation as best as possible (packages should communicate via interfaces) 
- Prefer collections over arrays 
- Never return *null*; instead, return an empty collection. e.g. *Collections.emptyList ()*
- Don't create empty collection just for *return* purposes, use *Collection.emptyList()* 
- Minimize mutability 
- Consider using *final* fields 
- Consider using *final* parameter in methods 
- Consider using the builder pattern 
- Consider the builder pattern when faced with too much constructor options 
- Consider the strategy pattern when faces with too many methods of identical operation (or to avoid *instance of*) 
- Use 3rd party libraries where possible – don’t re-invent the wheel 

= Unit/Integration Test  =

- In general if your code contain logic it can and should be tested (e.g. domain object has no logic) 
- Unit test should be unit and not integration, prefer mocking of callable objects 
- Integration tests should be identified by *IntegrationTest* suffix 
- Unit test must include assertion (output and/or logic) 
- Each unit test should include a single case (no multiple assertions) 
- Strive for *100%* code coverage when unit testing your classes 
- DAO tests should be transactional to prevent garbage in DB

= Spring Framework  =

- Prefer constructor injection 
-- Refrain from injecting directly to object's field 
- Prefer AOP over wrappers or empty super types where possible 
- Prefer singleton scope for beans 
- Prefer the use of object factories for prototype objects, this way it's easy to inject additional dependancies 
- Use configuration properties for configurable values (e.g. ${database.connection.max} )

= Persistency (Hibernate)  =

- Prefer JPA over Hibernate annotation over annotation mapping 
- HQL/SQL queries should be declared at the type level and not stored as strings 
- Objects shouldn't be familiar with their persistence mechanism 
- Domain object should be POJOs, setters methods and empty constructor should be private-package (default) visible 
- Don't include logic (like validation) in domain object, use *Hibernate Validator* or other validator pattern 
- Always implement *hashCode()* and *equals()* 
- Use *HashCodeBuilder* and *EqualsBuilder* (from Apache Commons) - don't use reflection building 
- For debug, implement *toString()* 
- Use *ToStringBuilder* (from Apache Commons) - don't use reflection building
