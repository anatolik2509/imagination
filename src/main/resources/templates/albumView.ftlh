<#import 'pageTemplate.ftl' as pageTemplate/>
<#import 'spring.ftl' as spring/>
<#import 'elements.ftl' as elements>
<#assign title>
    <@spring.message 'signIn.page.title'/>
</#assign>
<@pageTemplate.htmlTemplate title>
    <body>
    <@elements.header true/>
    <#list images as image>
        <@elements.image image false/>
    </#list>
    </body>
</@pageTemplate.htmlTemplate>