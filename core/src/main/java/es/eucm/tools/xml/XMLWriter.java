/**
 * eAdventure (formerly <e-Adventure> and <e-Game>) is a research project of the
 *    <e-UCM> research group.
 *
 *    Copyright 2005-2010 <e-UCM> research group.
 *
 *    You can access a list of all the contributors to eAdventure at:
 *          http://e-adventure.e-ucm.es/contributors
 *
 *    <e-UCM> is a research group of the Department of Software Engineering
 *          and Artificial Intelligence at the Complutense University of Madrid
 *          (School of Computer Science).
 *
 *          C Profesor Jose Garcia Santesmases sn,
 *          28040 Madrid (Madrid), Spain.
 *
 *          For more info please visit:  <http://e-adventure.e-ucm.es> or
 *          <http://www.e-ucm.es>
 *
 * ****************************************************************************
 *
 *  This file is part of eAdventure, version 2.0
 *
 *      eAdventure is free software: you can redistribute it and/or modify
 *      it under the terms of the GNU Lesser General Public License as published by
 *      the Free Software Foundation, either version 3 of the License, or
 *      (at your option) any later version.
 *
 *      eAdventure is distributed in the hope that it will be useful,
 *      but WITHOUT ANY WARRANTY; without even the implied warranty of
 *      MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *      GNU Lesser General Public License for more details.
 *
 *      You should have received a copy of the GNU Lesser General Public License
 *      along with eAdventure.  If not, see <http://www.gnu.org/licenses/>.
 */

package es.eucm.tools.xml;

import java.util.Map;

public class XMLWriter {

	public String generateString(XMLNode document) {
		String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>";
		xml += generateNode(document);
		return xml;
	}

	private String generateNode(XMLNode node) {
		String xml = "";
		xml += "<" + node.getNodeName();
		// write attributes
		for (Map.Entry<String, String> entry : node.getAttributes().entrySet()) {
			xml += " " + entry.getKey() + "=\"" + entry.getValue() + "\"";
		}
		if (node.hasChildNodes() || !"".equals(node.getNodeText())) {
			xml += ">";
			xml += node.getNodeText();
			for (XMLNode n : node.getChildren()) {
				xml += generateNode(n);
			}
			xml += "</" + node.getNodeName() + ">";
		} else {
			xml += "/>";
		}
		return xml;
	}
}
