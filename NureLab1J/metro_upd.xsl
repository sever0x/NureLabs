<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                xmlns:metro="http://shdwrazedev.com/metro_upd"
                xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
                xsi:schemaLocation="http://shdwrazedev.com/metro_upd metro_upd.xsd">
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
                    padding: 10px;
                    text-align: left;
                    }
                    th {
                    background-color: #f2f2f2;
                    }
                    .nodata {
                    color: #d3d3d3;
                    }
                </style>
            </head>
            <body>
                <h1>Metro Stations</h1>
                <table>
                    <tr>
                        <th>ID</th>
                        <th>Назва</th>
                        <th>Лінія</th>
                        <th>Місто</th>
                        <th>Наступна станція</th>
                        <th>Попередня станція</th>
                        <th>Перехід</th>
                    </tr>
                    <xsl:apply-templates select="metro:metro/metro:station"/>
                </table>
            </body>
        </html>
    </xsl:template>

    <xsl:template match="metro:station">
        <tr>
            <td><xsl:value-of select="@id"/></td>
            <td><xsl:value-of select="metro:name"/></td>
            <td><xsl:value-of select="metro:line"/></td>
            <td><xsl:value-of select="metro:city"/></td>
            <td>
                <xsl:choose>
                    <xsl:when test="metro:nextStation/metro:name">
                        <xsl:value-of select="metro:nextStation/metro:name"/>
                    </xsl:when>
                    <xsl:otherwise><span class="nodata">Немає даних</span></xsl:otherwise>
                </xsl:choose>
            </td>
            <td>
                <xsl:choose>
                    <xsl:when test="metro:prevStation/metro:name">
                        <xsl:value-of select="metro:prevStation/metro:name"/>
                    </xsl:when>
                    <xsl:otherwise><span class="nodata">Немає даних</span></xsl:otherwise>
                </xsl:choose>
            </td>
            <td>
                <xsl:choose>
                    <xsl:when test="metro:transferTo/metro:name">
                        <xsl:value-of select="metro:transferTo/metro:name"/>
                    </xsl:when>
                    <xsl:otherwise><span class="nodata">Немає даних</span></xsl:otherwise>
                </xsl:choose>
            </td>
        </tr>
    </xsl:template>
</xsl:stylesheet>
