<#import 'spring.ftl' as spring>
<#macro header authenticated>
    <header>
        <h1 class="logo">Imagination</h1>
        <div class="header-menu">
            <#if authenticated>
                <a href="#" class="header-menu-element"><@spring.message 'header.menu.feed'/></a>
                <a href="/profile" class="header-menu-element"><@spring.message 'header.menu.profile'/></a>
            <#else>
                <a href="/signUp" class="header-menu-element"><@spring.message 'header.menu.signUp'/>n</a>
                <a href="/signIn" class="header-menu-element"><@spring.message 'header.menu.signIn'/></a>
            </#if>
        </div>

    </header>
</#macro>