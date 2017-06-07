# $Id: sha.py,v 1.1 2010/09/07 12:25:27 gaufille Exp $
#
#  Copyright (C) 2005   Gregory P. Smith (greg@electricrain.com)
#  Licensed to PSF under a Contributor Agreement.

from hashlib import sha1 as sha
new = sha

blocksize = 1        # legacy value (wrong in any useful sense)
digest_size = 20
digestsize = 20
