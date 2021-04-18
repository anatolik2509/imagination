<#macro htmlTemplate title>
    <#import 'importFiles.ftl' as importFiles/>
    <html>
    <head>
        <title>${title}</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <@importFiles.files/>
    </head>
    <body>
        <#nested>
    </body>
    </html>
</#macro>
