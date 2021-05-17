<#import 'pageTemplate.ftl' as pageTemplate/>
<#import 'spring.ftl' as spring/>
<#import 'elements.ftl' as elements>
<#assign title>
    <@spring.message 'signIn.page.title'/>
</#assign>
<@pageTemplate.htmlTemplate title>
    <body class="main-color-bg">
    <@elements.header true/>
    ${account.email}
    <a href="/logout">Logout</a>
    </body>
</@pageTemplate.htmlTemplate>