<#import 'pageTemplate.ftl' as pageTemplate/>
<#import 'spring.ftl' as spring/>
<#import 'elements.ftl' as elements>
<#assign title>
    <@spring.message 'signUp.page.title'/>
</#assign>
<@pageTemplate.htmlTemplate title>
    <body class="main-color-bg">
    <@elements.header authenticated/>
    <div class="default-body container-sm center-container">
        <div class="sign-up-form center-container">
            <h1 class="sign-up-form-title"><@spring.message 'signUp.page.formTitle'/></h1>
            <form class="center-container" action="/signUp" method="post">
                <input class="sign-up-form-input" type="email" name="email"
                       placeholder="<@spring.message 'signUp.page.emailPlaceholder'/>"
                       value="${form.email}">
                <input class="sign-up-form-input" name="nickname"
                       placeholder="<@spring.message 'signUp.page.nicknamePlaceholder'/>"
                       value="${form.nickname}">
                <input class="sign-up-form-input" name="password" type="password"
                       placeholder="<@spring.message 'signUp.page.passwordPlaceholder'/>">
                <input class="sign-up-form-input" name="passwordRepeat" type="password"
                       placeholder="<@spring.message 'signUp.page.passwordRepeatPlaceholder'/>">
                <label>
                    <p class="form-label"><@spring.message 'signUp.page.birthDate'/></p>
                </label>
                <input type="date" name="birthDate" class="sign-up-form-input">
                <input class="sign-up-form-button" type="submit"
                       value="<@spring.message 'signUp.page.submit'/>">
                <#if errorList??>
                    <#list errorList as error>
                        <p class="error">${error.getDefaultMessage()}</p>
                    </#list>
                </#if>
                <#if emailError??>
                    <p class="error"><@spring.message 'signUp.valid.occupiedEmail'/></p>
                </#if>
                <a href="/signIn"><@spring.message 'signUp.page.alreadyHaveAccount'/></a>
            </form>
        </div>
    </div>
    </body>
</@pageTemplate.htmlTemplate>