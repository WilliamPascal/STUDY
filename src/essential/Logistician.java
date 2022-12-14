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

import java.util.NoSuchElementException;
import java.util.logging.Logger;

/**
 * The interface Logistician.
 */
public interface Logistician extends System.Logger {

    Logistician logger = ( Logistician ) Logger.getGlobal();
    Logistics defaultLogistics = Logistics.NORMAL;

    /**
     * Similarity system . logger . level.
     *
     * @param logistics the logistics
     * @return the system . logger . level
     */
    static System.Logger.Level similarity( final Logistics logistics )
            throws NoSuchElementException {
        switch ( logistics ) {
            case NONE       -> { return System.Logger.Level.OFF; }
            case MINOR      -> { return System.Logger.Level.INFO; }
            case NORMAL     -> { return System.Logger.Level.WARNING; }
            case MAJOR      -> { return System.Logger.Level.ERROR; }
            case SERIOUS    -> { return System.Logger.Level.DEBUG; }
            case DANGEROUS  -> { return System.Logger.Level.TRACE; }
            case ALL        -> { return System.Logger.Level.ALL; }
            default         -> throw new NoSuchElementException();
        }
    }

    static Logistics conversion( final System.Logger.Level level )
            throws NoSuchElementException {
        switch ( level ) {
            case OFF     -> { return Logistics.NONE; }
            case INFO    -> { return Logistics.MINOR; }
            case WARNING -> { return Logistics.NORMAL; }
            case ERROR   -> { return Logistics.MAJOR; }
            case DEBUG   -> { return Logistics.SERIOUS; }
            case TRACE   -> { return Logistics.DANGEROUS; }
            case ALL     -> { return Logistics.ALL; }
            default      -> throw new NoSuchElementException();
        }
    }

    boolean isLoggable( Level level );

    boolean isLoggable( final Logistics logistics );

    static boolean commonization( final Logistics logistics ) {
        return (
                logistics.equals( Logistics.NONE ) ||
                logistics.equals( Logistics.MINOR ) ||
                logistics.equals( Logistics.NORMAL ) ||
                logistics.equals( Logistics.MAJOR ) ||
                logistics.equals( Logistics.SERIOUS ) ||
                logistics.equals( Logistics.DANGEROUS ) ||
                logistics.equals( Logistics.ALL )
        );
    }
}
