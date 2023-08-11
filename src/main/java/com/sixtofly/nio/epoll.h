/* Copyright (C) 2002, 2003, 2004, 2005, 2006 Free Software Foundation, Inc.
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

#ifndef	_SYS_EPOLL_H
#define	_SYS_EPOLL_H	1

#include <stdint.h>
#include <sys/types.h>

/* Get __sigset_t.  */
#include <bits/sigset.h>

#ifndef __sigset_t_defined
# define __sigset_t_defined
typedef __sigset_t sigset_t;
#endif


enum EPOLL_EVENTS
  {
    EPOLLIN = 0x001, // 表示对应的文件描述符可读（包括对端Socket）
#define EPOLLIN EPOLLIN
    EPOLLPRI = 0x002, // 表示对应的文件描述符有紧急数据可读（带外数据）
#define EPOLLPRI EPOLLPRI
    EPOLLOUT = 0x004, // 表示对应的文件描述符可写
#define EPOLLOUT EPOLLOUT
    EPOLLRDNORM = 0x040,
#define EPOLLRDNORM EPOLLRDNORM
    EPOLLRDBAND = 0x080,
#define EPOLLRDBAND EPOLLRDBAND
    EPOLLWRNORM = 0x100,
#define EPOLLWRNORM EPOLLWRNORM
    EPOLLWRBAND = 0x200,
#define EPOLLWRBAND EPOLLWRBAND
    EPOLLMSG = 0x400,
#define EPOLLMSG EPOLLMSG
    EPOLLERR = 0x008, // 表示对应的文件描述符发生错误
#define EPOLLERR EPOLLERR
    EPOLLHUP = 0x010, // 表示对应的文件描述符被挂断
#define EPOLLHUP EPOLLHUP
    EPOLLONESHOT = (1 << 30), // 只监听一次事件，当监听完这次事件之后，如果还需要继续监听这个socket，需要再次
#define EPOLLONESHOT EPOLLONESHOT
    EPOLLET = (1 << 31) // 将EPOLL设为边缘触发（Edge Triggered），这是相对于水平触发（Level Triggered）而言的
#define EPOLLET EPOLLET
  };


/* Valid opcodes ( "op" parameter ) to issue to epoll_ctl().  */
#define EPOLL_CTL_ADD 1	/* Add a file decriptor to the interface.  */
#define EPOLL_CTL_DEL 2	/* Remove a file decriptor from the interface.  */
#define EPOLL_CTL_MOD 3	/* Change file decriptor epoll_event structure.  */

// 保存触发事件的某个文件描述符相关的数据
typedef union epoll_data
{
  void *ptr;
  int fd;
  uint32_t u32;
  uint64_t u64;
} epoll_data_t;
// 感兴趣的事件和被触发的事件
struct epoll_event
{
  uint32_t events;	/* Epoll events */
  epoll_data_t data;	/* User data variable */
};


__BEGIN_DECLS

/* Creates an epoll instance.  Returns an fd for the new instance.
   The "size" parameter is a hint specifying the number of file
   descriptors to be associated with the new instance.  The fd
   returned by epoll_create() should be closed with close().  */
extern int epoll_create (int __size) __THROW;


/* Manipulate an epoll instance "epfd". Returns 0 in case of success,
   -1 in case of error ( the "errno" variable will contain the
   specific error code ) The "op" parameter is one of the EPOLL_CTL_*
   constants defined above. The "fd" parameter is the target of the
   operation. The "event" parameter describes which events the caller
   is interested in and any associated user data.  */
extern int epoll_ctl (int __epfd, int __op, int __fd,
		      struct epoll_event *__event) __THROW;


/*
    等待 epoll 实例“epfd”上的事件。返回在“事件”缓冲区中返回的触发事件数。
    如果“errno”变量设置为特定的错误代码而出错，则为 -1。 “events”参数是一个包含触发事件的缓冲区。
    "maxevents" 是要返回的最大事件数（通常是 "events" 的大小）。
    “超时”参数以毫秒为单位指定最大等待时间（-1 == 无限）。

    此功能是取消点，因此未标记
    */
/* Wait for events on an epoll instance "epfd". Returns the number of
   triggered events returned in "events" buffer. Or -1 in case of
   error with the "errno" variable set to the specific error code. The
   "events" parameter is a buffer that will contain triggered
   events. The "maxevents" is the maximum number of events to be
   returned ( usually size of "events" ). The "timeout" parameter
   specifies the maximum wait time in milliseconds (-1 == infinite).

   This function is a cancellation point and therefore not marked with
   __THROW.  */
extern int epoll_wait (int __epfd, struct epoll_event *__events,
		       int __maxevents, int __timeout);


/* Same as epoll_wait, but the thread's signal mask is temporarily
   and atomically replaced with the one provided as parameter.

   This function is a cancellation point and therefore not marked with
   __THROW.  */
extern int epoll_pwait (int __epfd, struct epoll_event *__events,
			int __maxevents, int __timeout,
			__const __sigset_t *__ss);

__END_DECLS

#endif /* sys/epoll.h */
