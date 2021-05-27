<#import 'pageTemplate.ftl' as pageTemplate/>
<#import 'spring.ftl' as spring/>
<#import 'elements.ftl' as elements>
<#assign title>
    <@spring.message 'signIn.page.title'/>
</#assign>
<@pageTemplate.htmlTemplate title>
    <body>
    <@elements.header authenticated/>
    <script src="/js/PostsLoader.js"></script>
    <script src="/js/PostsLoader.js"></script>
    <div id="image-list" class="default-body container center-container">

    </div>
    </body>
</@pageTemplate.htmlTemplate>