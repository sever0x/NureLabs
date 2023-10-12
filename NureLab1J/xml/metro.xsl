<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                xmlns:metro="http://shdwrazedev.com/metro">
    <xsl:output method="html" version="4.0" encoding="UTF-8" indent="yes"/>

    <xsl:template match="/">
        <html>
            <head>
                <title>Metro Stations</title>
                <style>
                    table {
                    border-collapse: collapse;
                    width: 100%;
                    }
                    th, td {
                    border: 1px solid black;
                    padding: 8px;
                    text-align: left;
                    }
                    th {
                    background-color: #f2f2f2;
                    }
                </style>
            </head>
            <body>
                <h1>Metro Stations</h1>
                <table>
                    <tr>
                        <th>ID</th>
                        <th>Name</th>
                        <th>Line</th>
                        <th>City</th>
                    </tr>
                    <xsl:for-each select="metro:metro/metro:station">
                        <tr>
                            <td><xsl:value-of select="@id"/></td>
                            <td><xsl:value-of select="metro:name"/></td>
                            <td><xsl:value-of select="metro:line"/></td>
                            <td><xsl:value-of select="metro:city"/></td>
                        </tr>
                    </xsl:for-each>
                </table>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>
