<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:template match="/">
		<html>
			<title> Person </title>
			<xsl:apply-templates />
		</html>
	</xsl:template>

	<xsl:template match="person">
		<body>
			<h2>Person Information</h2>
			<hr />
			<xsl:apply-templates />
		</body>

	</xsl:template>

	<xsl:template match="name|age|city">
		<h3>
			<xsl:value-of select="name(.) " />
			:
			<xsl:value-of select="." /><h4></h4>
		</h3>
	</xsl:template>
</xsl:stylesheet>