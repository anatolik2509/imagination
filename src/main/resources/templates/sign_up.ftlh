<#import 'pageTemplate.ftl' as pageTemplate/>
<#import 'spring.ftl' as spring/>
<#import 'elements.ftl' as elements>
<#assign title>
    <@spring.message 'signUp.page.title'/>
</#assign>
<@pageTemplate.htmlTemplate title>
    <@elements.header true/>
</@pageTemplate.htmlTemplate>