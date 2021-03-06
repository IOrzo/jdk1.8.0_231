/* Compatibility definitions for System V `poll' interface.
   Copyright (C) 1994,1996-2001,2004,2005,2006 Free Software Foundation, Inc.
   This file is part of the GNU C Library.

   The GNU C Library is free software; you can redistribute it and/or
   modify it under the terms of the GNU Lesser General Public
   License as published by the Free Software Foundation; either
   version 2.1 of the License, or (at your option) any later version.

   The GNU C Library is distributed in the hope that it will be useful,
   but WITHOUT ANY WARRANTY; without even the implied warranty of
   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
   Lesser General Public License for more details.

   You should have received a copy of the GNU Lesser General Public
   License along with the GNU C Library; if not, write to the Free
   Software Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA
   02111-1307 USA.  */

#ifndef	_SYS_POLL_H
#define	_SYS_POLL_H	1

#include <features.h>

/* Get the platform dependent bits of `poll'.  */
#include <bits/poll.h>
#ifdef __USE_GNU
/* Get the __sigset_t definition.  */
# include <bits/sigset.h>
/* Get the timespec definition.  */
# define __need_timespec
# include <time.h>
#endif


/* Type used for the number of file descriptors.  */
typedef unsigned long int nfds_t;

/* Data structure describing a polling request.  */
struct pollfd
  {
    int fd;			/* File descriptor to poll.  */
    short int events;		/* Types of events poller cares about.  */
    short int revents;		/* Types of events that actually occurred.  */
  };


__BEGIN_DECLS

/*
轮询从 FDS 开始的 NFDS 结构描述的文件描述符。如果 TIMEOUT 非零且不为 -1，则允许 TIMEOUT 毫秒发生事件；
如果 TIMEOUT 为 -1，则阻塞直到事件发生。返回带有事件的文件描述符的数量，如果超时则为零，如果有错误则返回 -1。
*/
/* Poll the file descriptors described by the NFDS structures starting at
   FDS.  If TIMEOUT is nonzero and not -1, allow TIMEOUT milliseconds for
   an event to occur; if TIMEOUT is -1, block until an event occurs.
   Returns the number of file descriptors with events, zero if timed out,
   or -1 for errors.

   This function is a cancellation point and therefore not marked with
   __THROW.  */
extern int poll (struct pollfd *__fds, nfds_t __nfds, int __timeout);

#ifdef __USE_GNU
/* Like poll, but before waiting the threads signal mask is replaced
   with that specified in the fourth parameter.  For better usability,
   the timeout value is specified using a TIMESPEC object.

   This function is a cancellation point and therefore not marked with
   __THROW.  */
extern int ppoll (struct pollfd *__fds, nfds_t __nfds,
		  __const struct timespec *__timeout,
		  __const __sigset_t *__ss);
#endif

__END_DECLS

#endif	/* sys/poll.h */
