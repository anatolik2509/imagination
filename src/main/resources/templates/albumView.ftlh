<#import 'pageTemplate.ftl' as pageTemplate/>
<#import 'spring.ftl' as spring/>
<#import 'elements.ftl' as elements>
<#assign title>
    <@spring.message 'signIn.page.title'/>
</#assign>
<@pageTemplate.htmlTemplate title>
    <body>
    <@elements.header authenticated/>
    <div id="image-list" class="default-body container center-container">

        <#list images as image>
            <@elements.image image false/>
        </#list>
    </div>
    </body>
</@pageTemplate.htmlTemplate>