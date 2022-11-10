<?xml version="1.0"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" >
    <xsl:output method="html"/>
    <xsl:template match="/"><HTML><xsl:apply-templates /></HTML></xsl:template>
    <xsl:template match="Alumnos">
        <head><title>LISTADO DE ALUMNOS</title></head>
        <body>
            <h1>LISTA DE ALUMNOS</h1>
            <table border="1">
                <tr><th>Nombre</th><th>Edad</th></tr>
                <xsl:apply-templates select="Alumno" />
            </table>
        </body>
    </xsl:template>
    <xsl:template match="Alumno">
        <TR> <xsl:apply-templates /> </TR>
    </xsl:template>
    <xsl:template match="Nombre">
        <TD STYLE="font-size:14pt font-family:serif">
            <xsl:value-of select="."/> </TD>
    </xsl:template>
    <xsl:template match="Edad">
        <TD> <xsl:value-of select="."/> </TD>
    </xsl:template>
    <xsl:template match="Modulos"></xsl:template>
</xsl:stylesheet>
