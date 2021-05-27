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

        <form action="/album/add" method="post">
            <input name="imageId" type="hidden" value="${imageId}">
            <select name="albumId">
                <#list albums as album>
                    <option value="${album.id}">
                        <#outputformat "HTML">
                            ${album.name}
                        </#outputformat>
                    </option>
                </#list>
            </select>
            <input type="submit" class="btn btn-success" value="Add">
        </form>
    </div>
    </body>
</@pageTemplate.htmlTemplate>