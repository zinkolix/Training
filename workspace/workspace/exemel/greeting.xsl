<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:template match="/">
		<html>
			<title>Greeting</title>
			<xsl:apply-templates />
		</html>
	</xsl:template>

	<xsl:template match="greeting">
		<body>
			<h1>Greeting Demo</h1>
			<hr />
			<xsl:apply-templates />
		</body>
	</xsl:template>
	<xsl:template match="person|message">
		<h2>
			<xsl:value-of select="." />
		</h2>

	</xsl:template>
</xsl:stylesheet>