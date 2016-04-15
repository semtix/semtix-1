/*
 * Semtix Semesterticketbüroverwaltungssoftware entwickelt für das
 *        Semesterticketbüro der Humboldt-Universität Berlin
 *
 * Copyright (c) 2015 Michael Mertins (MichaelMertins@gmail.com)
 * 2011-2014 Jürgen Schmelzle (j.schmelzle@web.de)
 *
 *     This program is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU Affero General Public License as
 *     published by the Free Software Foundation, either version 3 of the
 *     License, or (at your option) any later version.
 *
 *     This program is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU Affero General Public License for more details.
 *
 *     You should have received a copy of the GNU Affero General Public License
 *     along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package org.semtix.gui.person.personensuche;

import org.semtix.gui.MainControl;

import javax.swing.*;
import java.awt.event.ActionEvent;

/**
 * 
 * Action zeigt Dialog zur Suche nach Personen an.
 */
@SuppressWarnings("serial")
public class ActionSuchePerson
extends AbstractAction {
	
	private MainControl mainControl;
	
	public ActionSuchePerson(String text, MainControl mainControl) {
		
		this.mainControl = mainControl;
				
		putValue(Action.NAME, text);
		putValue(Action.SHORT_DESCRIPTION, "Person suchen");


    }

    public void actionPerformed(ActionEvent event) {
    		new DialogPersonSuche(mainControl);    	
    }

}
