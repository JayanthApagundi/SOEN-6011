package com.example.sep;

/**
 * Provides version information following Semantic Versioning.
 * Format: MAJOR.MINOR.PATCH
 */
public class Version {
  public static final int MAJOR = 1;
  public static final int MINOR = 0;
  public static final int PATCH = 0;

  public static String getVersion() {
    return MAJOR + "." + MINOR + "." + PATCH;
  }
}
