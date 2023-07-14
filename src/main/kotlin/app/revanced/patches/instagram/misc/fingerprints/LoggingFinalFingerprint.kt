package app.revanced.patches.instagram.misc.fingerprints

import app.revanced.patcher.extensions.or
import app.revanced.patcher.fingerprint.method.impl.MethodFingerprint
import org.jf.dexlib2.AccessFlags
import org.jf.dexlib2.Opcode

object LoggingFinalFingerprint : MethodFingerprint(
    "Z",
    AccessFlags.PUBLIC or AccessFlags.FINAL,
    listOf("I"),
    customFingerprint = { methodDef, _ -> methodDef.name == "isLoggable" }
)