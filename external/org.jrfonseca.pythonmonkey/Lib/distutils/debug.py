import os

# This module should be kept compatible with Python 2.1.

__revision__ = "$Id: debug.py,v 1.1 2010/09/07 12:24:35 gaufille Exp $"

# If DISTUTILS_DEBUG is anything other than the empty string, we run in
# debug mode.
DEBUG = os.environ.get('DISTUTILS_DEBUG')
