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
        <form action="/album/create" method="post">
            <input name="albumName" placeholder="name">
            <input type="submit" class="btn btn-success" value="Add">
        </form>
        <#list albums as album>
            <a href="/album/${album.id}">${album.name}</a>
        </#list>
    </div>
    </body>
</@pageTemplate.htmlTemplate>