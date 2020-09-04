//  MXFlutterFramework
//  Copyright 2019 The MXFlutter Authors. All rights reserved.
//
//  Use of this source code is governed by a MIT-style license that can be
//  found in the LICENSE file.

import 'package:mxflutter/src/mirror/mx_mirror.dart';
import 'package:collection/src/iterable_zip.dart';
import 'dart:collection';

///把自己能处理的类注册到分发器中
Map<String, MXFunctionInvoke> registerIterableZipSeries() {
  var m = <String, MXFunctionInvoke>{};
  m[_iterableZip.funName] = _iterableZip;
  return m;
}

var _iterableZip = MXFunctionInvoke(
  "IterableZip",
  ({
    Iterable<Iterable<dynamic>> iterables,
  }) =>
      IterableZip(
    iterables,
  ),
  [
    "iterables",
  ],
);