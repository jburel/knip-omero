/*
 * org.openmicroscopy.shoola.env.rnd.data.BytesConverter
 *
 *------------------------------------------------------------------------------
 *  Copyright (C) 2006-2007 University of Dundee. All rights reserved.
 *
 *
 * 	This program is free software; you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation; either version 2 of the License, or
 *  (at your option) any later version.
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 * 
 *  You should have received a copy of the GNU General Public License along
 *  with this program; if not, write to the Free Software Foundation, Inc.,
 *  51 Franklin Street, Fifth Floor, Boston, MA 02110-1301 USA.
 *
 *------------------------------------------------------------------------------
 */
package org.knime.knip.omero.omerojava;

//Java imports

//Third-party libraries

//Application-internal dependencies

/**
 * 
 * 
 * @author Jean-Marie Burel &nbsp;&nbsp;&nbsp;&nbsp; <a
 *         href="mailto:j.burel@dundee.ac.uk">j.burel@dundee.ac.uk</a>
 * @author Donald MacDonald &nbsp;&nbsp;&nbsp;&nbsp; <a
 *         href="mailto:donald@lifesci.dundee.ac.uk"
 *         >donald@lifesci.dundee.ac.uk</a>
 * @version 3.0 <small> (<b>Internal version:</b> $Revision: $Date: $) </small>
 * @since OME3.0
 */
abstract class BytesConverter {

	/**
	 * Factory method to return an appropriate converter, depending on the pixel
	 * type.
	 * 
	 * @param pixelsType
	 *            The pixels type.
	 * @return A suitable converter.
	 */
	static BytesConverter getConverter(final String pixelsType) {
		if (PixelTypes.UINT_8.equals(pixelsType)
				|| PixelTypes.UINT_16.equals(pixelsType)
				|| PixelTypes.UINT_32.equals(pixelsType)) {
			return new UintConverter();
		} else if (PixelTypes.INT_8.equals(pixelsType)
				|| PixelTypes.INT_16.equals(pixelsType)
				|| PixelTypes.INT_32.equals(pixelsType)) {
			return new IntConverter();
		} else if (PixelTypes.FLOAT.equals(pixelsType)) {
			return new FloatConverter();
		} else if (PixelTypes.DOUBLE.equals(pixelsType)) {
			return new DoubleConverter();
		}
		return null;
	}

	/**
	 * Converts a sequence of bytes, representing a pixel value, into a numeric
	 * value of appropriate type, taking endianness into account. The value
	 * returned by this method is a <code>double</code>.
	 * 
	 * @param data
	 *            The byte array containing the bytes to convert.
	 * @param offset
	 *            The position of the first byte making up the pixel value.
	 * @param length
	 *            The number of bytes that make up the pixel value.
	 * @return An object to wrap the actual numeric value.
	 */
	public abstract double pack(ReadOnlyByteArray data, int offset, int length);

}
