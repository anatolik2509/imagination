<#import 'pageTemplate.ftl' as pageTemplate/>
<#import 'spring.ftl' as spring/>
<#import 'elements.ftl' as elements>
<#assign title>
    <@spring.message 'signIn.page.title'/>
</#assign>
<@pageTemplate.htmlTemplate title>
    <body class="main-color-bg">
    <@elements.header true/>
    <div class="default-body container-sm center-container">
        <div class="sign-up-form center-container">
            <form enctype="multipart/form-data" class="center-container" action="/image/replace/${imageId}" method="post">
                <input id="file" class="sign-up-form-input" type="file" accept="image/png" name="file">
                <button id="upload" class="sign-up-form-button" type="submit">
                    Replace
                </button>
            </form>
        </div>
    </div>
    </body>
</@pageTemplate.htmlTemplate>