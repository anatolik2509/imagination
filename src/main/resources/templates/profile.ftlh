<#import 'pageTemplate.ftl' as pageTemplate/>
<#import 'spring.ftl' as spring/>
<#import 'elements.ftl' as elements>
<#assign title>
    <@spring.message 'signIn.page.title'/>
</#assign>
<@pageTemplate.htmlTemplate title>
    <body>
    <@elements.header true/>
    <script src="/js/ProfileButtonsConfigurer.js"></script>
    <div class="default-body container center-container">
        <h2>${account.nickname}</h2>
        <p>${account.email}</p>
        <#if account.viewerOwner>
            <a class="btn btn-primary" href="/profile/edit">Edit</a>
            <a class="btn btn-danger" href="/logout">Logout</a>
        <#elseif account.viewerAdmin>
            <#if account.state!="BANNED">
                <button id="ban-button" data-id="${account.id}" data-state="0" class="btn btn-danger">Ban</button>
            <#else>
                <button id="ban-button" data-id="${account.id}" data-state="1" class="btn btn-danger">Unban</button>
            </#if>

        </#if>
        <#if account.viewerOwner == false>
            <#if account.subscribed>
                <button id="subscribe-button" data-id="${account.id}" data-state="1" class="btn btn-danger">
                    Unsubscribe
                </button>
            <#else>
                <button id="subscribe-button" data-id="${account.id}" data-state="0" class="btn btn-success">
                    Subscribe
                </button>
            </#if>
        </#if>
    </div>
    </body>
</@pageTemplate.htmlTemplate>