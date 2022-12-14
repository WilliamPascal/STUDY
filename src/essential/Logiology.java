/*
 *     https://github.com/WilliamPascal/STUDY
 *     Copyright (C) 2022  William Pascal
 *
 *     This program is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     This program is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 *
 *     You should have received a copy of the GNU General Public License
 *     along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */

package essential;

import echo.BasicOutput;

import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.ResourceBundle;
import java.util.logging.Logger;

/**
 * The type Logiology.
 */
public class Logiology implements Logistician {

    String      name;
    boolean     isLoggable;
    Logistician logistician;

    /**
     * Instantiates a new Logiology.
     *
     * @param name      the name
     * @param logistics the logistics
     */
    public Logiology( final String name, final Logistics logistics ) {
        this.name        = name;
        this.isLoggable  = isLoggable( logistics );
        this.logistician = Logistician.logger;
    }

    /**
     * Instantiates a new Logiology.
     *
     * @param logistician the logistician
     */
    public Logiology( final Logistician logistician ) {
        try {
            this.name        = logistician.getName();
            this.isLoggable  = isLoggable( Logistician.similarity( Logistician.defaultLogistics ) );
            this.logistician = logistician;
        } catch ( NoSuchElementException nsee ) {
            new BasicOutput( logistician, Logistics.ALL, DyeColors.FRED,
                             nsee.getLocalizedMessage() );
        }
    }

    /**
     * @return 
     */
    @Override
    public String getName() {
        return this.name;
    }

    /**
     * @param level 
     * @return
     */
    public boolean isLoggable( Level level ) {
        try {
            return Logistician.commonization( Logistician.conversion( level ) );
        } catch ( NoSuchElementException nsee ) {
            new BasicOutput( logistician, Logistics.ALL, DyeColors.FRED,
                             nsee.getLocalizedMessage() );
        }
        throw new IllegalStateException();
    }

    /**
     *
     * @param logistics
     * @return
     */
    public boolean isLoggable( final Logistics logistics ) {
        try {
            return Logistician.commonization( logistics );
        } catch ( NoSuchElementException nsee ) {
            new BasicOutput( logistician, Logistics.ALL, DyeColors.FRED,
                             nsee.getLocalizedMessage() );
        }
        throw new IllegalStateException();
    }

    /**
     * @param level
     * @param resourceBundle
     * @param s
     * @param throwable
     */
    public void log( System.Logger.Level level, ResourceBundle resourceBundle, String s,
                     Throwable throwable
    ) {
        Objects.requireNonNull( level );
        Logger.getGlobal().setResourceBundle( resourceBundle );
        Logger.getGlobal().log( System_Logger_Level2java_util_logging_Level( level ), s, throwable );
    }

    /**
     * @param level
     * @param resourceBundle
     * @param s
     * @param objects
     */
    public void log( System.Logger.Level level, ResourceBundle resourceBundle, String s,
                     Object... objects
    ) {
        Objects.requireNonNull( level );
        Logger.getGlobal().logrb( System_Logger_Level2java_util_logging_Level( level ), resourceBundle, s, objects );
    }

    private static java.util.logging.Level System_Logger_Level2java_util_logging_Level( final System.Logger.Level System_Logger_Level ) {
        switch ( System_Logger_Level ) {
            case OFF -> {
                return java.util.logging.Level.OFF;
            }
            case INFO -> {
                return java.util.logging.Level.INFO;
            }
            case WARNING -> {
                return java.util.logging.Level.WARNING;
            }
            case ERROR -> {
                return java.util.logging.Level.SEVERE;
            }
            // Unknown case(non-matched)
            case DEBUG -> {
                return java.util.logging.Level.FINEST;
            }
            // Unknown case(non-matched)
            case TRACE -> {
                return java.util.logging.Level.FINER;
            }
            case ALL -> {
                return java.util.logging.Level.ALL;
            }
            default -> throw new NoSuchElementException();
        }
    }

}
