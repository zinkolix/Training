<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:template match="/">
		<html>
			<title> Employee Details</title>
			<xsl:apply-templates />
		</html>
	</xsl:template>

	<xsl:template match="organization">
		<body bgcolor="wheat" text="spinach">
			<h1>Employee Details</h1>
			<hr />
			<table border="2">
				<tr>
					<th>ID</th>
					<th>Dept</th>
					<th>Name</th>
					<th>Salary</th>
				</tr>
				<xsl:for-each select="employee">
					<xsl:if test="salary > 1000">
						<tr>
							<td>
								<xsl:value-of select="@id" />
							</td>
							<td>
								<xsl:value-of select="@dept" />
							</td>
							<td>
								<xsl:value-of select="name" />
							</td>
							<td>
								<xsl:value-of select="salary" />
							</td>
						</tr>
					</xsl:if>
				</xsl:for-each>

			</table>
		</body>
	</xsl:template>
</xsl:stylesheet>