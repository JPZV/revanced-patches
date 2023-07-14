package app.revanced.patches.instagram.misc.fingerprints

import app.revanced.patcher.extensions.or
import app.revanced.patcher.fingerprint.method.impl.MethodFingerprint
import org.jf.dexlib2.AccessFlags
import org.jf.dexlib2.Opcode

object LoggingFingerprint : MethodFingerprint(
    "Z",
    AccessFlags.PUBLIC.value,
    listOf("I"),
    customFingerprint = { methodDef, _ -> methodDef.name == "isLoggable" }
)