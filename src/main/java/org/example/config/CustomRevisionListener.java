package org.example.config;

// ENVERS pra auditoria
import org.example.audit.Revision;
import org.hibernate.envers.RevisionListener;


public class CustomRevisionListener implements RevisionListener {
    public void newRevision(Object revisionEntity)
    {
        final Revision revision = (Revision) revisionEntity;
    }
}
