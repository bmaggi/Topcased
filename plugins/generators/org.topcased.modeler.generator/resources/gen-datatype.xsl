<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet  version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

	<xsl:param name="edatatype"/>
	
	<xsl:template match="/documentation">
		<html>
			<head>
				<title>Documentation for <xsl:value-of select="@metamodel"/> meta model</title>
			</head>
			<body>
				<p align="center"><font size="3" face="arial">TOPCASED<br/>Eclipse Documentation for <xsl:value-of select="@metamodel"/></font></p>
				<font size="2" face="arial">
					<xsl:apply-templates select="//edatatype[@name=$edatatype]"/>
				</font>
			</body>
		</html>
	</xsl:template>
	
	
	<xsl:template match="edatatype">
		<li><i>EDATATYPE</i>&#160;<xsl:value-of select="@name"/></li>
		<table>
				<xsl:apply-templates select="./*[not(local-name()='eannotations')]"/>
		</table>
		<xsl:apply-templates select="./*[local-name()='eannotations']"/>
		<hr/>
	</xsl:template>
	
	<xsl:template match="instance-class-name">
		<tr>
			<td><font size="2"><b>Instance class name</b></font></td>
			<td><font size="2"><xsl:value-of select="."/></font></td>
		</tr>
	</xsl:template>
	
	<xsl:template match="eenums">
		<tr>
			<td><font size="2"><b>Values</b></font></td>
			<td><font size="2"><xsl:apply-templates/></font></td>
		</tr>
	</xsl:template>

	<xsl:template match="eenum">
		<xsl:value-of select="@name"/>&#160;
	</xsl:template>
	
	
	<xsl:template match="eannotations">
		<xsl:apply-templates/>
	</xsl:template>
	
	<xsl:template match="eannotation">
		<p align="justify">
			<i><b><xsl:value-of select="@name"/>:</b></i>&#160;
			<xsl:value-of select="."/>
		</p>
	</xsl:template>
	
	
	<xsl:template match="@*|node()">
		<xsl:apply-templates/>
	</xsl:template>
	
</xsl:stylesheet>
