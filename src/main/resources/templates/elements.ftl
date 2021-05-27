<#import 'spring.ftl' as spring>
<#macro header authenticated>
    <header>
        <h1 class="logo">Imagination</h1>
        <div class="header-menu">
            <#if authenticated == true>
                <a href="/feed" class="header-menu-element"><@spring.message 'header.menu.feed'/></a>
                <a href="/profile" class="header-menu-element"><@spring.message 'header.menu.profile'/></a>
                <a href="/image/upload" class="header-menu-element">Upload</a>
            <#else>
                <a href="/signUp" class="header-menu-element"><@spring.message 'header.menu.signUp'/></a>
                <a href="/signIn" class="header-menu-element"><@spring.message 'header.menu.signIn'/></a>
            </#if>
        </div>

    </header>
</#macro>

<#macro image image commentButton>
    <div class="image-container">
        <img class="image" src="/media/${image.path}">
        <#--        <#if image.viewerLiked>-->
        <#--            <button class="like-btn btn btn-danger" data-id="${image.id}" data-state="1">Dislike</button>-->
        <#--        <#else>-->
        <#--            <button class="like-btn btn btn-success" data-id="${image.id}" data-state="0">Like</button>-->
        <#--        </#if>-->
        <#if commentButton>
            <a class="btn btn-primary" href="/image/${image.id}">Comments</a>
        </#if>
        <a class="btn btn-primary" href="/image/upload/${image.id}">Reply</a>
        <a class="btn btn-primary" href="/thread/${image.id}">Thread</a>
        <a class="btn btn-primary" href="/album/add?imageId=${image.id}">Add to album</a>
        <#if image.viewerOwner>
            <a class="btn btn-primary" href="/image/replace/${image.id}">Update</a>
            <button class="delete-btn btn btn-danger" data-url="/image/delete/${image.id}">Delete</button>
        </#if>
        <script src="/js/DeleteButtonConfigurer.js"></script>
    </div>
</#macro>

<#macro comment comment>
    <div class="comment-container">
        <p>${comment.authorName}</p>
        <#outputformat "HTML">
            <p>${comment.content}</p>
        </#outputformat>



    </div>
</#macro>