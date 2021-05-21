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
            <form class="center-container" action="/profile/edit" method="post">
                <input class="sign-up-form-input" name="nickname" placeholder="New nickname">
                <input class="sign-up-form-button" type="submit" value="Update">
            </form>
        </div>
    </div>
    </body>
</@pageTemplate.htmlTemplate>