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

package echo;

import essential.*;
import org.jetbrains.annotations.Nullable;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author william
 */
public class BasicOutput {

    final Logistician logistician;
    final Logistics   level;
    final AbstractDyeable dye;
    final String      content;

    /**
     * Common output (not file output)
     * @param logistics level
     * @param color     color
     */
    public BasicOutput( final Logistician         logistician,
                        final Logistics           logistics,
                        @Nullable final DyeColors color,
                        final String              content
    ) {
        this.logistician = logistician;
        this.level       = logistics;
        this.dye         = new Dyeable( color );
        this.content     = content;
    }

    /**
     * @param logistician  Logger
     * @param logistics    level
     * @param color        color
     * @param content      content
     * @param dest         dest file to output to
     * @param doOverWrite  if false, do appending
     */
    public BasicOutput( final Logistician         logistician,
                        final Logistics           logistics,
                        @Nullable final DyeColors color,
                        final String              content,
                        final File                dest,
                        boolean                   doOverWrite
    ) {
        this.logistician = logistician;
        this.level       = logistics;
        this.dye         = new Dyeable( color );
        this.content     = content;

        // Egression to dest by overwriting
        if ( doOverWrite ) {
            try ( FileWriter writer = new FileWriter( dest ) ) {
                writer.write( content );

            } catch ( IOException e ) {
                new BasicOutput( Logistician.logger,
                                 Logistics.ALL,
                                 DyeColors.BRED,
                                 "Captured an IOException"
                );
            }
        }

    }

}
