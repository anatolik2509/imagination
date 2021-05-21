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
            <h1 class="sign-up-form-title"><@spring.message 'signIn.page.formTitle'/></h1>
            <form class="center-container" action="/signIn" method="post">
                <input class="sign-up-form-input" type="email" name="email"
                       placeholder="<@spring.message 'signIn.page.emailPlaceholder'/>">
                <input class="sign-up-form-input" name="password" type="password"
                       placeholder="<@spring.message 'signIn.page.passwordPlaceholder'/>">
                <label for="remember-me"><@spring.message 'signIn.page.RememberMePlaceholder'/></label>
                <input type="checkbox" id="remember-me" name="remember-me">
                <input class="sign-up-form-button" type="submit"
                       value="<@spring.message 'signIn.page.submit'/>">

                <#if error??>
                    <p><@spring.message 'signIn.error.incorrectInputs'/></p>
                </#if>
                <a href="/signUp"><@spring.message 'signUp.page.alreadyHaveAccount'/></a>
                <a href="https://github.com/login/oauth/authorize?client_id=${clientId}&redirect_uri=http%3A%2F%2Flocalhost%3A8080%2Foauth">
                    Sign In GitHub
                </a>
            </form>
        </div>
    </div>
    </body>
</@pageTemplate.htmlTemplate>