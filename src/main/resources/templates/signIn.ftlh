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
            <h1 class="sign-up-form-title"><@spring.message 'signIn.page.formTitle'/></h1>
            <form class="center-container" action="/signIn" method="get">
                <input class="sign-up-form-input" type="email" name="email"
                       placeholder="<@spring.message 'signIn.page.emailPlaceholder'/>">
                <input class="sign-up-form-input" name="password" type="password"
                       placeholder="<@spring.message 'signIn.page.passwordPlaceholder'/>">
                <input class="sign-up-form-input" name="remember-me" type="checkbox"
                       placeholder="<@spring.message 'signIn.page.RememberMePlaceholder'/>">
                <input class="sign-up-form-button" type="submit"
                       value="<@spring.message 'signIn.page.submit'/>">
                <a href="/signIn"><@spring.message 'signIn.page.haventAccount'/></a>

            </form>
        </div>
    </div>
    </body>
</@pageTemplate.htmlTemplate>