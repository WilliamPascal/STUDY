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

import org.jetbrains.annotations.Nullable;

import java.util.NoSuchElementException;

/**
 * The interface Dye.
 * @author william
 */
public abstract class AbstractDyeable {

    static final int  NULL_DIGIT = 0;

    final boolean     isDyeable;

    /** Fore(3) or Back(4) */
    final int         forb;
    /** dyeing color code(0 to 7) */
    final int         digi;

    protected AbstractDyeable( @Nullable final DyeColors color ) {
        // In this situation, FBLA is selected. (Fore Black)
        // Therefor, BBLAC does not exist. (Back Black)
        if ( color == null ) {
            this.isDyeable = true;
            this.digi      = NULL_DIGIT;
            this.forb      = NULL_DIGIT;
            return;
        }
        this.isDyeable = true;
        this.forb      = ( isFore( color ) ? 3 : 4 );
        this.digi      = digiCode( color );
    }

    private static boolean isFore( @Nullable final DyeColors color ) {

        // In this situation, FBLA is selected. (Fore Black)
        // Therefor, BBLAC does not exist. (Back Black)
        if ( color == null ) {
            return true;
        }

        return color == DyeColors.FRED ||
                color == DyeColors.FGRE ||
                color == DyeColors.FBLU ||
                color == DyeColors.FYEL ||
                color == DyeColors.FMAG ||
                color == DyeColors.FCYA ||
                color == DyeColors.FWHI;
    }

    private static int digiCode( @Nullable final DyeColors color ) {

        if ( color == null ) {
            return NULL_DIGIT;
        }

        switch ( color ) {

            case FRED, BRED -> { return 1; }
            case FGRE, BGRE -> { return 2; }
            case FBLU, BBLU -> { return 3; }
            case FYEL, BYEL -> { return 4; }
            case FMAG, BMAG -> { return 5; }
            case FCYA, BCYA -> { return 6; }
            case FWHI, BWHI -> { return 7; }

            default -> throw new NoSuchElementException();
        }

    }

    public boolean isDyeable() {
        return isDyeable;
    }

}
