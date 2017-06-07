<xsl:stylesheet version="1.0" xmlns:fo="http://www.w3.org/1999/XSL/Format" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:output indent="yes" method="xml"/>
	<xsl:template match="/documentation">
		<fo:root xmlns:fo="http://www.w3.org/1999/XSL/Format">
			<fo:layout-master-set>
				<fo:simple-page-master master-name="first"
					page-height="297mm" page-width="210mm"
					margin-top="20mm" margin-bottom="20mm"
					margin-left="25mm" margin-right="25mm">
					<fo:region-body margin-bottom="20mm"/>
					<fo:region-after region-name="footer-first" extent="200mm"/>
				</fo:simple-page-master>
				<fo:simple-page-master master-name="rest"
					page-height="297mm" page-width="210mm"
					margin-top="20mm" margin-bottom="10mm"
					margin-left="25mm" margin-right="25mm">
					<fo:region-body margin-bottom="20mm"/>
					<fo:region-after region-name="footer-rest" extent="10mm"/>
				</fo:simple-page-master>
				<fo:page-sequence-master master-name="document">
					<fo:repeatable-page-master-alternatives>
						<fo:conditional-page-master-reference page-position="first"
							master-reference="first"/>
						<fo:conditional-page-master-reference page-position="rest"
							master-reference="rest"/>
					</fo:repeatable-page-master-alternatives>
				</fo:page-sequence-master>
			</fo:layout-master-set>
			<fo:page-sequence master-reference="document">
				<fo:static-content flow-name="footer-first">
					<fo:block text-align="center">
						TOPCASED DOCUMENTATION FOR META MODEL <xsl:value-of select="@metamodel"/>
					</fo:block>
				</fo:static-content>
				<fo:static-content flow-name="footer-rest">
					<fo:block text-align-last="center" font-size="8pt">Page <fo:page-number/></fo:block>
				</fo:static-content>
				<fo:flow flow-name="xsl-region-body">
					<fo:block/>
					<fo:block break-before="page"/>
					<xsl:apply-templates/>
				</fo:flow>
			</fo:page-sequence>
		</fo:root>
	</xsl:template>

	<xsl:template match="epackage">
		<fo:block font-family="monospace" font-size="14pt" space-after="0.5cm" space-before="0.5cm">
			EPACKAGE <xsl:value-of select="@name"/>
		</fo:block>
		<xsl:apply-templates/>
	</xsl:template>

	<xsl:template match="edatatypes">
		<fo:block font-family="monospace" font-weight="bold" font-size="12pt" space-after="0.5cm" space-before="0.5cm">
			EDATATYPES list
		</fo:block>
		<fo:list-block provisional-distance-between-starts="15mm" provisional-label-separation="5mm">
			<xsl:apply-templates/>
		</fo:list-block>
	</xsl:template>

	<xsl:template match="edatatype">
		<fo:list-item space-before="0.5cm">
			<fo:list-item-label start-indent="5mm" end-indent="label-end()">
				<fo:block>
					<xsl:number format="1."/>
				</fo:block>
			</fo:list-item-label>
			<fo:list-item-body start-indent="body-start()">
				<fo:block font-weight="bold" space-after="0.25cm">
					<xsl:value-of select="@name"/>
				</fo:block>
				<fo:block>
					<xsl:apply-templates select="./*[not(local-name()='eannotations')]"/>
					<xsl:apply-templates select="./*[local-name()='eannotations']"/>
				</fo:block>
			</fo:list-item-body>
		</fo:list-item>
	</xsl:template>

	<xsl:template match="instance-class-name">
		<fo:block>
			<fo:inline font-style="italic">Instance class name</fo:inline>:&#160;
			<xsl:choose>
				<xsl:when test="text()!=''">
					<xsl:value-of select="."/>
				</xsl:when>
				<xsl:otherwise>
					none
				</xsl:otherwise>
			</xsl:choose>
		</fo:block>
	</xsl:template>

	<xsl:template match="eenums">
		<fo:block>
			<fo:inline font-style="italic">Values</fo:inline>:&#160;<xsl:apply-templates/>
		</fo:block>
	</xsl:template>

	<xsl:template match="eenum">
		<xsl:value-of select="@name"/>&#160;
	</xsl:template>


	<xsl:template match="eannotations">
		<xsl:apply-templates/>
	</xsl:template>

	<xsl:template match="eannotation">
		<fo:block space-before="0.25cm">
			<fo:inline font-style="italic"><xsl:value-of select="@name"/></fo:inline>:&#160;<xsl:value-of select="."/>
		</fo:block>
	</xsl:template>

	<xsl:template match="eclasses">
		<fo:block break-before="page" font-family="monospace" font-weight="bold" font-size="12pt" space-after="0.5cm" space-before="0.5cm">
			ECLASSES list
		</fo:block>
		<fo:list-block provisional-distance-between-starts="15mm" provisional-label-separation="5mm">
			<xsl:apply-templates/>
		</fo:list-block>
	</xsl:template>

	<xsl:template match="eclass">
		<fo:list-item space-before="0.5cm">
			<fo:list-item-label start-indent="5mm" end-indent="label-end()">
				<fo:block>
					<xsl:number format="1."/>
				</fo:block>
			</fo:list-item-label>
			<fo:list-item-body start-indent="body-start()">
				<fo:block font-weight="bold" space-after="0.25cm">
					<xsl:value-of select="@name"/>
				</fo:block>
				<xsl:for-each select="@*[local-name()!='name']">
					<fo:block>
						<fo:inline font-style="italic"><xsl:value-of select="local-name()"/></fo:inline>:&#160;<xsl:value-of select="."/>
					</fo:block>
				</xsl:for-each>
				<fo:block>
					<xsl:apply-templates select="instance-class-name"/>
					<xsl:apply-templates select="eannotations"/>
					<xsl:apply-templates select="eattributes"/>
					<xsl:apply-templates select="ereferences"/>
					<xsl:apply-templates select="eoperations"/>
				</fo:block>
			</fo:list-item-body>
		</fo:list-item>
	</xsl:template>

	<xsl:template match="eattributes">
		<xsl:if test="eattribute">
			<fo:block font-weight="bold" space-before="0.5cm">
				EAttributes list :
			</fo:block>
			<fo:list-block provisional-distance-between-starts="5mm" provisional-label-separation="5mm">
				<xsl:apply-templates/>
			</fo:list-block>
		</xsl:if>
	</xsl:template>

	<xsl:template match="eattribute">
		<fo:list-item space-before="0.5cm">
			<fo:list-item-label start-indent="15mm" end-indent="label-end()">
				<fo:block>
					<xsl:number format="a."/>
				</fo:block>
			</fo:list-item-label>
			<fo:list-item-body start-indent="body-start()">
				<fo:block font-weight="bold" space-after="0.25cm">
					<xsl:value-of select="@name"/>
				</fo:block>
				<xsl:for-each select="@*[local-name()!='name']">
					<block><xsl:value-of select="local-name()"/>&#160;<xsl:value-of select="."/></block>
				</xsl:for-each>
				<fo:block><fo:inline font-style="italic">etype</fo:inline>:&#160;<xsl:value-of select="etype"/></fo:block>
				<fo:block><fo:inline font-style="italic">lower-bound</fo:inline>:&#160;<xsl:value-of select="lower-bound"/></fo:block>
				<fo:block><fo:inline font-style="italic">upper-bound</fo:inline>:&#160;<xsl:value-of select="upper-bound"/></fo:block>								
			</fo:list-item-body>
		</fo:list-item>
	</xsl:template>

  <xsl:template match="ereferences">
		<xsl:if test="ereference">
			<fo:block font-weight="bold" space-before="0.5cm">
				EReferences list :
			</fo:block>
			<fo:list-block provisional-distance-between-starts="5mm" provisional-label-separation="5mm">
				<xsl:apply-templates/>
			</fo:list-block>
		</xsl:if>
	</xsl:template>

	<xsl:template match="ereference">
		<fo:list-item space-before="0.5cm">
			<fo:list-item-label start-indent="15mm" end-indent="label-end()">
				<fo:block>
					<xsl:number format="a."/>
				</fo:block>
			</fo:list-item-label>
			<fo:list-item-body start-indent="body-start()">
				<fo:block font-weight="bold" space-after="0.25cm">
					<xsl:value-of select="@name"/>
				</fo:block>
				<xsl:for-each select="@*[local-name()!='name']">
					<block><xsl:value-of select="local-name()"/>&#160;<xsl:value-of select="."/></block>
				</xsl:for-each>
				<fo:block><fo:inline font-style="italic">etype</fo:inline>:&#160;<xsl:value-of select="etype"/></fo:block>
				<fo:block><fo:inline font-style="italic">lower-bound</fo:inline>:&#160;<xsl:value-of select="lower-bound"/></fo:block>
				<fo:block><fo:inline font-style="italic">upper-bound</fo:inline>:&#160;<xsl:value-of select="upper-bound"/></fo:block>
				<xsl:apply-templates/>					
			</fo:list-item-body>
		</fo:list-item>
	</xsl:template>

	<xsl:template match="eoperations">
		<xsl:if test="eoperation">
			<fo:block font-weight="bold" space-before="0.5cm">
				EOperations list :
			</fo:block>
			<fo:list-block provisional-distance-between-starts="5mm" provisional-label-separation="5mm">
				<xsl:for-each select="eoperation">
					<xsl:call-template name="displayEoperation">
						<xsl:with-param name="eoperation" select="."/>
					</xsl:call-template>
				</xsl:for-each>
			</fo:list-block>
		</xsl:if>
	</xsl:template>

	<xsl:template name="displayEoperation">
		<xsl:param name="eoperation"/>
		<fo:list-item space-before="0.5cm">
			<fo:list-item-label start-indent="15mm" end-indent="label-end()">
				<fo:block>
					<xsl:number format="a."/>
				</fo:block>
			</fo:list-item-label>
			<fo:list-item-body start-indent="body-start()">
				<fo:block font-weight="bold" space-after="0.25cm">
					<xsl:value-of select="$eoperation/@name"/>
				</fo:block>
				<xsl:for-each select="@*[local-name()!='name']">
					<block><xsl:value-of select="local-name()"/>&#160;<xsl:value-of select="."/></block>
				</xsl:for-each>
				<fo:block><fo:inline font-style="italic" text-decoration="underline">Return type</fo:inline>:&#160;<xsl:value-of select="$eoperation/etype"/></fo:block>
				<xsl:if test="$eoperation/eparameters/eparameter">
					<fo:block>
						<fo:inline font-style="italic" text-decoration="underline">
							Parameters
						</fo:inline>
						<xsl:for-each select="$eoperation/eparameters/eparameter">
							<fo:block>
								<fo:inline font-style="italic"><xsl:value-of select="@name"/></fo:inline>:&#160;<xsl:value-of select="etype"/>
							</fo:block>
						</xsl:for-each>
					</fo:block>
				</xsl:if>
				<fo:block space-before="0.25cm">
					<xsl:value-of select="$eoperation/@name"/>(<xsl:for-each select="$eoperation/eparameters/eparameter"><xsl:if test="position()!=1"> ; </xsl:if><fo:inline font-style="italic"><xsl:value-of select="@name"/></fo:inline>:&#160;<xsl:value-of select="etype"/></xsl:for-each>): <xsl:value-of select="$eoperation/etype"/>
				</fo:block>
			</fo:list-item-body>
		</fo:list-item>
	</xsl:template>


	<xsl:template match="@*|node()">
		<xsl:apply-templates/>
	</xsl:template>
</xsl:stylesheet>
