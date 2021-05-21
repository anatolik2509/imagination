<#import 'pageTemplate.ftl' as pageTemplate/>
<#import 'spring.ftl' as spring/>
<#import 'elements.ftl' as elements>
<#assign title>
    <@spring.message 'signIn.page.title'/>
</#assign>
<@pageTemplate.htmlTemplate title>
    <body>
    <@elements.header true/>
    <div class="default-body container center-container">
        <@elements.image image false/>
        <#list image.comments as comment>
            <@elements.comment comment/>
        </#list>
        <form action="/comment/add?imageId=${image.id}" method="post">
            <input name="content" placeholder="Comment">
            <input type="submit" class="btn btn-success" value="Send">
        </form>
    </div>
    </body>
</@pageTemplate.htmlTemplate>