<#import 'pageTemplate.ftl' as pageTemplate/>
<#import 'spring.ftl' as spring/>
<#import 'elements.ftl' as elements>
<#assign title>
    <@spring.message 'signIn.page.title'/>
</#assign>
<@pageTemplate.htmlTemplate title>
    <body class="main-color-bg">
    <@elements.header true/>
    <div class="default-body center-container">
        <div class="sign-up-form center-container">
            <h1 class="sign-up-form-title"><@spring.message 'signUp.page.formTitle'/></h1>
            <form class="center-container" action="/signIn" method="get">
                <input class="sign-up-form-input" type="email" name="email"
                       placeholder="<@spring.message 'signUp.page.emailPlaceholder'/>">
                <input class="sign-up-form-input" name="nickname"
                       placeholder="<@spring.message 'signUp.page.nicknamePlaceholder'/>">
                <input class="sign-up-form-input" name="password" type="password"
                       placeholder="<@spring.message 'signUp.page.passwordPlaceholder'/>">
                <input class="sign-up-form-input" name="passwordRepeat" type="password"
                       placeholder="<@spring.message 'signUp.page.passwordRepeatPlaceholder'/>">
                <input class="sign-up-form-button" type="submit"
                       value="<@spring.message 'signUp.page.submit'/>">
                <a href="/signIn"><@spring.message 'signUp.page.alreadyHaveAccount'/></a>
            </form>
        </div>
    </div>
    </body>
</@pageTemplate.htmlTemplate>