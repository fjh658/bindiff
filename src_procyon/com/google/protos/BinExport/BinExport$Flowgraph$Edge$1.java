package com.google.protos.BinExport;

import com.google.protobuf.*;

final class BinExport$Flowgraph$Edge$1 extends AbstractParser
{
    @Override
    public BinExport$Flowgraph$Edge parsePartialFrom(final CodedInputStream codedInputStream, final ExtensionRegistryLite extensionRegistryLite) {
        try {
            return new BinExport$Flowgraph$Edge(codedInputStream, extensionRegistryLite, null);
        }
        catch (RuntimeException ex) {
            if (ex.getCause() instanceof InvalidProtocolBufferException) {
                throw (InvalidProtocolBufferException)ex.getCause();
            }
            throw ex;
        }
    }
}
