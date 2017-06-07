<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet  version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

	<xsl:template match="/documentation">
		<xsl:processing-instruction name="NLS">TYPE="org.eclipse.help.toc"</xsl:processing-instruction>
		
		<toc label="{@metamodel} Metamodel">
			<topic label="EDataTypes"  href="html/types/main.html"> 
				<xsl:for-each select="/documentation//edatatype">
					<xsl:sort select="@name"/>
					<topic label="{@name}" href="html/types/{@name}.html"/> 
				</xsl:for-each>

			</topic>
			<topic label="EClasses" href="html/classes/main.html"> 
				<xsl:for-each select="/documentation//eclass">
					<xsl:sort select="@name"/>								
					<topic label="{@name}" href="html/classes/{@name}.html"/> 
				</xsl:for-each>
			</topic>
		</toc>
	</xsl:template>

</xsl:stylesheet>
