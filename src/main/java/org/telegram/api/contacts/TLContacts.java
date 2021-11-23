/**
 * This is the source code of Telegram Bot v. 2.0
 * It is licensed under GNU GPL v. 3 or later.
 * You should have received a copy of the license in this archive (see LICENSE).
 *
 * Copyright Ruben Bermudez, 13/11/14.
 */
package org.telegram.api.contacts;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.telegram.api.contact.TLContact;
import org.telegram.api.user.TLAbsUser;
import org.telegram.tl.StreamingUtils;
import org.telegram.tl.TLContext;
import org.telegram.tl.TLVector;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

@NoArgsConstructor
@Getter
@Setter
public class TLContacts extends TLAbsContacts {
    /**
     * The constant CLASS_ID.
     */
    public static final int CLASS_ID = 0x6f8b8cb2;

    private TLVector<TLContact> contacts;
    private TLVector<TLAbsUser> users;

    public int getClassId() {
        return CLASS_ID;
    }

    public void serializeBody(OutputStream stream)
            throws IOException {
        StreamingUtils.writeTLVector(this.contacts, stream);
        StreamingUtils.writeTLVector(this.users, stream);
    }

    public void deserializeBody(InputStream stream, TLContext context)
            throws IOException {
        this.contacts = StreamingUtils.readTLVector(stream, context, TLContact.class);
        this.users = StreamingUtils.readTLVector(stream, context, TLAbsUser.class);
    }

    public String toString() {
        return "contacts.contacts#6f8b8cb2";
    }
}