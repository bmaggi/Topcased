<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet  version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	
	<xsl:template match="documentation">
		<html>
			<head>
				<title>Documentation for <xsl:value-of select="@metamodel"/> meta model</title>
			</head>
			<body>
				<p align="center"><font size="3" face="arial">TOPCASED<br/>Eclipse Documentation for <xsl:value-of select="@metamodel"/></font></p>
				<table>
					<tr>
						<td><i>EClasses</i></td>
						<td><i>EDatatypes</i></td>
					</tr>
					<tr>
						<td valign="top">
							<xsl:for-each select="/documentation//eclass">
								<xsl:sort select="@name"/>
								<a href="#eclass_{@name}"><xsl:value-of select="@name"/></a><br/>
							</xsl:for-each>
						</td>
						<td valign="top">
							<xsl:for-each select="/documentation//edatatype">
								<xsl:sort select="@name"/>								
								<a href="#edatatype_{@name}"><xsl:value-of select="@name"/></a><br/>
							</xsl:for-each>
						</td>
					</tr>
				</table>
				<font size="2" face="arial">
					<xsl:apply-templates/>
				</font>
			</body>
		</html>
	</xsl:template>
	
	<xsl:template match="epackage">
		<hr/>
			<font size="3">EPACKAGE <xsl:value-of select="@name"/></font>
		<hr/>
		<xsl:apply-templates/>
	</xsl:template>
	
	<xsl:template match="edatatypes">
		<xsl:apply-templates/>
	</xsl:template>
	
	<xsl:template match="edatatype">
		<a name="edatatype_{@name}"/>
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
	
	<xsl:template match="eclasses">
		<xsl:apply-templates/>
	</xsl:template>
	
	<xsl:template match="eclass">
		<a name="eclass_{@name}"/>	
		<i>ECLASS</i>&#160;<xsl:value-of select="@name"/><br/><br/>
			<table>
				<xsl:for-each select="@*">
					<tr>
						<td><font size="2" face="arial"><b><xsl:value-of select="local-name()"/></b></font></td>
						<td><font size="2" face="arial"><xsl:value-of select="."/></font></td>
					</tr>
				</xsl:for-each>
				<xsl:apply-templates select="instance-class-name"/>
			</table>		
			<xsl:apply-templates select="eannotations"/>
			<xsl:apply-templates select="eattributes"/>
			<xsl:apply-templates select="eoperations"/>
		<hr/>
	</xsl:template>
	
	<xsl:template match="eattributes">
			<xsl:if test="eattribute">
				<i>EAttributes</i>
				<ul>
					<xsl:apply-templates/>
				</ul>
			</xsl:if>
	</xsl:template>
	
	<xsl:template match="eattribute">
		<li><xsl:value-of select="@name"/></li>
		<table>
			<xsl:for-each select="@*[local-name()!='name']">
				<tr>
					<td><font size="2" face="arial"><b><xsl:value-of select="local-name()"/></b></font></td>
					<td><font size="2" face="arial"><xsl:value-of select="."/></font></td>
				</tr>
			</xsl:for-each>
				<tr>
					<td><font size="2" face="arial"><b>etype</b></font></td>
					<td><font size="2" face="arial"><xsl:value-of select="etype"/></font></td>
				</tr>
				<tr>
					<td><font size="2" face="arial"><b>lower-bound</b></font></td>
					<td><font size="2" face="arial"><xsl:value-of select="lower-bound"/></font></td>
				</tr>
				<tr>
					<td><font size="2" face="arial"><b>upper-bound</b></font></td>
					<td><font size="2" face="arial"><xsl:value-of select="upper-bound"/></font></td>
				</tr>
		</table>	
	</xsl:template>
	
	<xsl:template match="eoperations">
		<xsl:if test="eoperation">
			<i>EOperations</i>
			<xsl:for-each select="eoperation">
				<table width="50%" border="1" cellpadding="1" cellspacing="1">
					<xsl:call-template name="displayEoperation">
						<xsl:with-param name="eoperation" select="."/>
					</xsl:call-template>
				</table>
				<br/>
			</xsl:for-each>
		</xsl:if>
	</xsl:template>
	
	<xsl:template name="displayEoperation">
	<xsl:param name="eoperation"/>
		<tr>
			<td colspan="2" align="center"><font size="2" face="arial"><b><xsl:value-of select="$eoperation/@name"/></b></font></td>
		</tr>
		<tr>
			<td><font size="2" face="arial">Return type</font></td>
			<td><font size="2" face="arial"><xsl:value-of select="$eoperation/etype"/></font></td>
		</tr>
		 <tr>
			<td>Parameters</td>
			<td>
				<xsl:if test="$eoperation/eparameters/eparameter">
					<table width="100%" border="1" cellpadding="0" cellspacing="0">
						<tr>
							<td align="center"><font size="2" face="arial">Name</font></td>
							<td align="center"><font size="2" face="arial">Etype</font></td>
						</tr>
						<xsl:for-each select="$eoperation/eparameters/eparameter">
							<tr>
								<td><font size="2" face="arial"><xsl:value-of select="@name"/></font></td>
								<td><font size="2" face="arial"><xsl:value-of select="etype"/></font></td>
							</tr>
						</xsl:for-each>
					</table>					
				</xsl:if>
			</td>
		</tr>
	</xsl:template>
	
	<xsl:template match="@*|node()">
		<xsl:apply-templates/>
	</xsl:template>
	
</xsl:stylesheet>